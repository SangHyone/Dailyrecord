package kr.human.ISP.config;

import java.io.IOException;

import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class SocketTextHandler extends TextWebSocketHandler {

	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message)
			throws InterruptedException, IOException {

		String payload = message.getPayload();
		JSONObject jsonObject = new JSONObject(payload);
		String str = jsonObject.get("user").toString();
		if(str.contains("회원") || str.contains("멤버")){
			if(str.contains("가입") || str.contains("등록")) {
				if(str.contains("조건")) {
					session.sendMessage(new TextMessage("이름과 이메일,전화번호 입력만으로 간편하게 가입하실수 있습니다."));	
				}else {
					session.sendMessage(new TextMessage("회원가입은 우측상단 메뉴바 클릭하시면 버튼이 보입니다."));
				}
			}else if(str.contains("수정")){
				session.sendMessage(new TextMessage("회원정보 수정은 마이페이지->회원정보수정에서 수정하실수 있습니다."));	
			}else if(str.contains("이메일")) {
				if(str.contains("인증")) {
					session.sendMessage(new TextMessage("회원가입시 이메일 인증 절차가 진행되기때문에 필수로 진행하셔야합니다."));	
				}else {
					session.sendMessage(new TextMessage("저는 멍청이라 이런말은 몰라요"));	
				}
			}else {
				session.sendMessage(new TextMessage("준비되어있는 답변키워드가 아닙니다.  회원 관련 예시 키워드 : 회원, 멤버, 가입, 등록, 참여, 수정"));	
			}
		}else if(str.contains("모임")){
			if(str.contains("참여") || str.contains("신청")) {
				session.sendMessage(new TextMessage("로그인 후에 모임에서 신청가능합니다."));	
			}else if(str.contains("")) {
				
			}
		}else if(str.contains("탈퇴")||str.contains("삭제")) {
			if(str.contains("회원")||str.contains("모임")) {
				session.sendMessage(new TextMessage("안됩니다. 놓아주지 않을거에요."));	
			}else if(str.contains("모임")) {
				session.sendMessage(new TextMessage("모임시간이 지난 후 자동으로 삭제가 진행됩니다. 그럼에도 불구하고 삭제하시려면 내 모임 보기->삭제버튼 클릭 하시면 됩니다."));
			}
		}else if(str.contains("비밀번호")) {
			if(str.contains("변경")) {
				session.sendMessage(new TextMessage("마이페이지에서 변경가능합니다."));	
			}else if(str.contains("분실")||str.contains("찾기")||str.contains("잃어")||str.contains("잊어")||str.contains("까먹")) {
				session.sendMessage(new TextMessage("비밀번호를 분실하신 경우 비밀번호 찾기를 통해 비밀번호를 재설정하실 수 있습니다."));	
			}
		}else if(str.contains("아이디")||str.contains("이메일")||str.contains("계정")) {
			if(str.contains("찾기")||str.contains("잃어")||str.contains("잊어")||str.contains("까먹")||str.contains("분실")) {
				
			}else if(str.contains("인증")) {
				
			}
		}
	}

}