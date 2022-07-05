package kr.human.di.vo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Bond {
	 
    @Autowired
    //@Qualifier("Mustang")
    @Qualifier("ferari") // 동일한 타입의 객체가 복수로 존재할 경우 객체를 지정해 준다.
    private Car car;
     
    public void showCar(){
        car.getCarName();
    }
}
