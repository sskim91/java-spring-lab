package com.example.excelpoiji.poiji;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.example.excelpoiji.model.Car;
import com.example.excelpoiji.model.Ntic;
import com.poiji.bind.Poiji;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.List;

/**
 * @author sskim
 */
public class BcryptEncoderExample {
    public static void main(String[] args) throws Exception{


        File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "nitc.xlsx");
        List<Ntic> ntics = Poiji.fromExcel(file, Ntic.class);
        ntics.forEach(i -> {
            String s = BCrypt.withDefaults().hashToString(10, i.getPASSWORD().toCharArray());
            System.out.println(s);
        });
    }
}
