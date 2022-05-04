package kr.human.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/*
데이터를 그룹화하기 Stream <T> 인터페이스의 collect() 메서드를 사용할 수 있습니다 .

<R> R collect(Supplier<R> supplier, BiConsumer<R,? super T> accumulator, BiConsumer<R,R> combiner)
<R,A> R collect(Collector<?  super T,A,R> collector)

collect () 메소드의 첫 번째 버전은 세 가지 인수를 사용합니다.
결과를 저장하기 위해 변경 가능한 컨테이너를 제공하는 공급자입니다.
결과를 변경 가능한 컨테이너에 누적하는 누적 기입니다.
병렬로 사용될 때 부분 결과를 결합하는 결합기.
 */
public class StreamEx10 {
	public static void main(String[] args) {
		List<String> names = Employee.persons().stream()
				.map(Employee::getName)
				.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		System.out.println(names);

		names = Employee.persons().stream().map(Employee::getName).collect(Collectors.toList());
		System.out.println(names);
		
		int[] ar = {1,2,3,4,5,6,7,8,9,10};
		List<Integer> list =  Arrays.stream(ar).boxed().collect(Collectors.toList()); // 배열을 리스트로 
		System.out.println(list);
		
		// Set으로 만들기
		Set<String> nameSet = Employee.persons().stream().map(Employee::getName).collect(Collectors.toSet());
		System.out.println(nameSet);
		
		nameSet = Employee.persons().stream().map(Employee::getName).collect(Collectors.toCollection(TreeSet::new));
		System.out.println(nameSet);
		
	}
}
