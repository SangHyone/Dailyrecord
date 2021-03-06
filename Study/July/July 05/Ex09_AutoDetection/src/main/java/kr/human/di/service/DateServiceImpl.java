package kr.human.di.service;

import org.joda.time.LocalDate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
@Service("dateService")
@Slf4j
public class DateServiceImpl implements DateService {

	@Override
	public LocalDate getNextAssessmentDate() {
		log.info("{} getNextAssessmentDate() 호출", this.getClass().getCanonicalName());
		return new LocalDate(2022,8,1);
	}

}
