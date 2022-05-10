package sooyong;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author sskim
 */
public class Homework {
    public static void main(String[] args) throws Exception {

        String json = "{\"UserToken\":\"usertoken\",\"success\":true,\"message\":\"message\",\"error_code\":\"\",\"result\":[{\"Category\":\"etc\",\"CategoryName\":\"충전/제휴\",\"CategorySeq\":0,\"CodeList\":[{\"CodeName\":\"전체선택\",\"Code\":\"0\"},{\"CodeName\":\"LPG\",\"Code\":\"lpg\"},{\"CodeName\":\"수소\",\"Code\":\"h2\"},{\"CodeName\":\"전기\",\"Code\":\"ev\"},{\"CodeName\":\"경정비\",\"Code\":\"fix\"},{\"CodeName\":\"쇼핑/문화\",\"Code\":\"shop\"}]},{\"Category\":\"service\",\"CategoryName\":\"서비스\",\"CategorySeq\":1,\"CodeList\":[{\"CodeName\":\"전체선택\",\"Code\":\"0\"},{\"CodeName\":\"복합충전소\",\"Code\":\"s_18\"},{\"CodeName\":\"오카페이\",\"Code\":\"s_14\"},{\"CodeName\":\"네이버페이\",\"Code\":\"s_16\"},{\"CodeName\":\"카카오페이\",\"Code\":\"s_15\"},{\"CodeName\":\"제로페이\",\"Code\":\"s_17\"},{\"CodeName\":\"스마트페이\",\"Code\":\"s_12\"},{\"CodeName\":\"세차기\",\"Code\":\"s_clean\"},{\"CodeName\":\"고속도로\",\"Code\":\"o_ex\"}]}]}";

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        //JSON의 모든 데이터를 파싱하는 것이 아닌 내가 필요로 하는 데이터, 즉 내가 필드로 선언한 데이터들만 파싱할 수 있다.
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        ResultDTO resultDTO = objectMapper.readValue(json, ResultDTO.class);
        System.out.println(resultDTO);

    }
}
