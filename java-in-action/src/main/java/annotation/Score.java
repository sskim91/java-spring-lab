package annotation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by sskim on 2021/06/06
 * Github : http://github.com/sskim91
 */
@Getter
@Setter
@AllArgsConstructor
public class Score {
    @MaxLength(5)
    public String name;
    public int no;
    public int kor;
    public int eng;
    public int math;
}
