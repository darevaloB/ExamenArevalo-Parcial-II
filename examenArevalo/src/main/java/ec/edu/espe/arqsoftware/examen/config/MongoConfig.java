/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.examen.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import java.math.BigDecimal;
import java.util.Arrays;
import org.bson.types.Decimal128;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

/**
 *
 * @author Diana
 */
@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration{
    
    @Override
    protected String getDatabaseName() {
        return "examenArevalo";
    }

    @Override
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb+srv://anabel_15:Ihq2py3IDp55vit4@dbgestion.uiutx.mongodb.net/examenArevalo?retryWrites=true&w=majority");
    }

    @Override
    public boolean autoIndexCreation() {
        return true;
    }

    @Bean
    @Override
    public MappingMongoConverter mappingMongoConverter(MongoDatabaseFactory databaseFactory, MongoCustomConversions customConversions, MongoMappingContext mappingContext) {
        MappingMongoConverter converter = super.mappingMongoConverter(databaseFactory, customConversions, mappingContext);
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
        return converter;
    }

    /**
     * Inject a CustomConversions bean to overwrite the default mapping of BigDecimal.
     *
     * @return a new instance of CustomConversons
     */
//    @Bean
//    @Override
//    public MongoCustomConversions customConversions() {
//        Converter<Decimal128, BigDecimal> decimal128ToBigDecimal = new Converter<>() {
//            @Override
//            public BigDecimal convert(Decimal128 s) {
//                return s == null ? null : s.bigDecimalValue();
//            }
//        };
//
//        Converter<BigDecimal, Decimal128> bigDecimalToDecimal128 = new Converter<>() {
//            @Override
//            public Decimal128 convert(BigDecimal s) {
//                return s == null ? null : new Decimal128(s);
//            }
//        };
//
//        return new MongoCustomConversions(Arrays.asList(decimal128ToBigDecimal, bigDecimalToDecimal128));
//    }

}
