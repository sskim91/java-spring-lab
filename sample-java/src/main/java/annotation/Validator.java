package annotation;

import java.lang.reflect.Field;

/**
 * Created by sskim on 2021/06/06
 * Github : http://github.com/sskim91
 */
public class Validator {
    public void execute(Score score) throws Exception{
        //Score 객체의 모든 필드 가져옴, 단 접근 제어자가 public
        Field[] fields = score.getClass().getFields();
        for (Field field : fields) {
            //MaxLength 애노테이션 확인
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength anno = field.getAnnotation(MaxLength.class);
                int AnnoMax = anno.value();
                int NameMax = field.get(score).toString().length();
                if (NameMax > AnnoMax) {
                    System.out.printf("%s 필드의 최대 글자수는 %d자 입니다. 입력한 문자 [%s]\n", field.getName(), AnnoMax, field.get(score).toString());
                }
            }
        }
    }
}
