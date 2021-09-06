package sn.gainde2000.orbuslink.visa.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.NamingConventions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 
 * @author MTHIAM
 *
 */

@Configuration
public class VsConfiguration {
	
	@Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

	    @Bean
	    public ModelMapper modelMapper() {
	        ModelMapper modelMapper = new ModelMapper();
	        modelMapper.getConfiguration()
	                .setFieldMatchingEnabled(true)
	                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
	                .setSourceNamingConvention(NamingConventions.JAVABEANS_MUTATOR);
	        return modelMapper;
	    }

}
