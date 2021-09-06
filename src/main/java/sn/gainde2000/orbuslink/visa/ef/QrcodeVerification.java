package sn.gainde2000.orbuslink.visa.ef;

import lombok.Data;

import java.util.List;

@Data
public class QrcodeVerification {
    Boolean ok ;
    List<String> positives;
    List<String> negatives;

}
