package com.structural;

import java.util.HashMap;
import java.util.Map;

//현재 객체가 또 다른 포함객체를 가진 원형으로 pool을 생성 
class SubjectFlyweightFactory {
	private static final Map<String, Score> pool = new HashMap<>();
}

public class FlyweightScore {

}
