package sn.gainde2000.orbuslink.visa.ef;

import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
public class ExcelVerification {
    Boolean ok ;
    List<String> positives;
   List<String> negatives;
   String pathReport;


}
