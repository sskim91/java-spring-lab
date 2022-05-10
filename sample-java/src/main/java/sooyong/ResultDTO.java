package sooyong;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author sskim
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ResultDTO {

    private String UserToken;
    private List<InnerCategories> result;

    @Getter
    @ToString
    @NoArgsConstructor
    static public class InnerCategories{
        private String Category;
        private String CategoryName;
        private String CategorySeq;
        private List<CodeListDTO> CodeList;
    }

    @Getter
    @ToString
    @NoArgsConstructor
    static public class CodeListDTO{
        private String CodeName;
        private String Code;
    }
}
