package kr.human.ISP.controller;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.human.ISP.MoimCreateService.LikeMoimServiceImpl;
import kr.human.ISP.MoimCreateService.MoimCreateService;
import kr.human.ISP.MoimCreateService.MoimViewService;
import kr.human.ISP.MoimCreateService.ReviewServiceImpl;
import kr.human.ISP.MoimCreateService.SingUpServiceImpl;
import kr.human.ISP.service.UserServiceImpl;
import kr.human.ISP.vo.LikeMoimVO;
import kr.human.ISP.vo.MoimVO;
import kr.human.ISP.vo.ReviewVO;
import kr.human.ISP.vo.SignUpVO;
import kr.human.ISP.vo.UpFileVO;
import kr.human.ISP.vo.UserVO;
import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class MoimController {

	@Autowired
	private MoimViewService moimViewService;
	
	@Autowired
	private SingUpServiceImpl signUpService;
	
	@Autowired
	private ReviewServiceImpl reviewService;
	
	@Autowired
	private LikeMoimServiceImpl likeMoimService;
	
	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private MoimCreateService moimCreateService;
	
	// application.properties에 등록된 파일의 경로를 가져온다.
	String filePath="C:\\upload\\";
	
	
	
	
	// 모임 만들기 페이지 
	@RequestMapping(value = "/MoimCreate")
	public String createMoim(Model model, HttpSession session) {
		List<String> LC_list = moimCreateService.selectAllLcname();
		model.addAttribute("LC_list", LC_list);
		
		try {
			filePath = new ClassPathResource("/static/upload/").getFile().getAbsolutePath();
			log.info("서버 절대 경로 : {}", filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		UserVO userVO = (UserVO) session.getAttribute("userVO");
		UpFileVO profileImg=moimCreateService.getProfile(userVO.getUser_idx());
		System.out.println("프로필"+profileImg);
		model.addAttribute("path",filePath);
		model.addAttribute("profileImg",profileImg);
		
		return "moim/MoimCreate";
	}
	
	
	
	// 모임 생성 버튼 누르면 진행하는 insert
	@ResponseBody
	@RequestMapping(value = "/moimInsertOk")
	public ResponseEntity<?> createMoimInsert(@ModelAttribute MoimVO moimVO) {
		log.info("받은 VO : {}", moimVO);
		String str = moimVO.getMoim_time();
		str = str.replace('T', ' ');
		moimVO.setMoim_time(str);
		
		String str2 = moimVO.getMoim_deadline();
		str2 = str2.replace('T', ' ');
		moimVO.setMoim_deadline(str2);
		log.info("바꾼 VO : {}", moimVO);
		
		moimCreateService.insert(moimVO);
		
		MoimVO idxYong = moimCreateService.selectByNewOneMoim();
		
		moimCreateService.moimCategoryInsert(idxYong.getMoim_idx(), moimVO.getLc_name(), moimVO.getSc_name());		
		HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/"));		
		return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
	}
	
	
	
	
	
	
	

	// 모임만들기 페이지에서 category 선택을 가져오는 부분
	@ResponseBody
	@RequestMapping(value = "/Category")
	public List<String> scList(@RequestParam(required = false, name = "lc_name") String lc_name) {
		List<String> SC_list = null;
		if(lc_name != null || lc_name.trim().length() >0) {
			SC_list = moimCreateService.selectByScname(lc_name);
		}				
		return SC_list;
	}
	
	
	@RequestMapping(value = "/profileUploadForm")
	public String profileUploadForm() {
		return "moim/profileUpload";
	}
	
	
	@GetMapping(value = "/profileUploadFormOk")
	public String moimImage_get() {
		return "redirect:moim/profileUpload";
	}
	
	@PostMapping(value = "/profileUploadFormOk")
	@ResponseBody
	public String moimImage_Post(@RequestParam("profileImg") MultipartFile uploadfile) {
		if(uploadfile!=null) {
			try {
				filePath = new ClassPathResource("/static/upload/").getFile().getAbsolutePath();
				log.info("서버 절대 경로 : {}", filePath);
			} catch (IOException e) {
				e.printStackTrace();
			}
			long sizeInBytes=uploadfile.getSize();
			if(sizeInBytes>0){ // 파일크기가 있을때만
				String oriName = uploadfile.getOriginalFilename();
		        String saveName = UUID.randomUUID().toString() + "_" + oriName ;  // 겹치지않는 ID를 만들어준다. 
		        
       
				UpFileVO upfileVO = new UpFileVO();
				upfileVO.setUser_idx(1);
				upfileVO.setO_fileName(oriName);
				upfileVO.setS_fileName(saveName);
				UpFileVO profile=moimCreateService.getProfile(1);
				// 프로필사진이 db에 저장안되있으면 저장
		        if(profile==null) {
		        	System.out.println(moimCreateService.uploadProfileImg(upfileVO)); // db저장
		        	// 파일 저장
		        	File newFileName = new File(filePath +"/"+ saveName);
			        try {
						uploadfile.transferTo(newFileName);
					} catch (IllegalStateException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
		        }// 프로필사진이 db에 저장되어있으면 수정
		        else {
		        	// 기존 프로필파일 로컬에서 삭제
		        	File file=new File(filePath+"/"+profile.getS_fileName());
		        	file.delete();
		        	// 새로운 프로필사진 로컬에 저장
		        	File newFileName = new File(filePath +"/"+ saveName);
			        try {
						uploadfile.transferTo(newFileName);
					} catch (IllegalStateException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
		        	System.out.println(moimCreateService.updateProfileImg(upfileVO));
		        }
		        
				return filePath+profile.getS_fileName();
			}
		} 
		  return "error";
	}
	
	
	// ---------------------------------------------------------------------
	// 여기 밑으로 새롬이 컨트롤러
	
	


	@RequestMapping(value="signUp2")
	public String signUp(Model model) {
		return "signUp2";
	}
	
	//게시글 idx 가지고 오기. 게시물만든사람 정보유저정보 참여자 정보 까지!
		//참석자가 있을떄 버튼 참여완료로 보이게 해야됨.1.
		@RequestMapping("/moim1")
		public String view(
				@RequestParam Map<String, String> params, HttpServletRequest request, 
				@ModelAttribute MoimVO moimVO,UserVO userVO,ReviewVO reviewVO,SignUpVO signUpVO,Model model) {
			//게시글 한개 가지고오기 다른사람이랑 합치고 동적으로 수정해야됨!
			
			MoimVO vo = null;
			try {
				vo = moimViewService.selectByIdx(81);
				UserVO user = userService.selectByIdx(vo.getUser_idx());
				List<ReviewVO> review = reviewService.selectByMoimPlusName(vo.moim_idx);
				List<UserVO> userSignUp_list = userService.selectSignUpList(vo.moim_idx);
				model.addAttribute("vo",vo);
				model.addAttribute("userVO",user);
				model.addAttribute("review",review);
				model.addAttribute("userSignUp_list",userSignUp_list);

			} catch (SQLException e) {
				e.printStackTrace();
			}
					

			return "moim/MoimView";
		}
		//참여신청하기
		@RequestMapping(value="signUp_insert",method = RequestMethod.POST, produces = "text/plain; charset=utf-8")
		@ResponseBody
		public void signUp_insert(@ModelAttribute SignUpVO signUpVO) { 
			signUpService.insert(signUpVO);		
		}
		//참여신청취소하기
		@RequestMapping(value="signUp_delete",method = RequestMethod.POST, produces = "text/plain; charset=utf-8")
		@ResponseBody
		public void signUp_delete(@ModelAttribute SignUpVO signUpVO,int signUp_idx) { 
			signUpService.delete(signUp_idx);
		}
		
		
		//후기저장하기
		@RequestMapping(value="commentInsert")
		@ResponseBody
		public void commentInsert(@ModelAttribute ReviewVO reviewVO) {	
			reviewService.insert(reviewVO);		
		}

		//ajax 후기삭제하기 
		@RequestMapping(value = "commentDelete", method = RequestMethod.POST, produces = "text/plain; charset=utf-8")
		@ResponseBody
		public void commentDelete(@ModelAttribute ReviewVO reviewVO,int review_idx) {
			reviewService.updateIsDelete(review_idx);		
		}

		//ajax 후기수정하기 
		@RequestMapping(value = "commentUpdate", method = RequestMethod.POST, produces = "text/plain; charset=utf-8")
		@ResponseBody
		public void commentUpdate(@ModelAttribute ReviewVO reviewVO) {
			System.out.println(reviewVO);
			reviewService.update(reviewVO);		
		}

		
		//ajax 찜하기 
		@RequestMapping(value = "likeInsert", method = RequestMethod.POST, produces = "text/plain; charset=utf-8")
		@ResponseBody
		public void likeInsert(@ModelAttribute LikeMoimVO likeMoimVO) {
			likeMoimService.insert(likeMoimVO);
			
		}
		//ajax 찜 취소하기
		@RequestMapping(value = "likeDelete", method = RequestMethod.POST, produces = "text/plain; charset=utf-8")
		@ResponseBody
		public void likeDelete(@RequestParam int user_idx) {
			likeMoimService.delete(user_idx);
		}
		
		
	
	
	
	
	
}
