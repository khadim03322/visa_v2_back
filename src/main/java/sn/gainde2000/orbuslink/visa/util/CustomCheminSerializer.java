package sn.gainde2000.orbuslink.visa.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomCheminSerializer extends StdSerializer<Object> {
    @Value("${urlFolder}")
    private String sourceFile;
    public CustomCheminSerializer() {
        this(null);
    }

    public CustomCheminSerializer(Class<Object> t) {
        super(t);
    }
    @Override
    public void serialize(Object s, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        //jsonGenerator.writeString(Base64EncodeDecode.encoder(this.sourceFile+s));
        if (s instanceof String){
            jsonGenerator.writeString(this.sourceFile+s);
        }
        else {
            List<String> urls=(List<String>)s;
            List<String> newUrls=new ArrayList<>();
            for (String c: urls){
                newUrls.add(this.sourceFile.concat(c));
            }
            jsonGenerator.writeObject(newUrls);
        }
    }
}
