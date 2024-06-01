package clv.cos.odc.customized_dietary.common.util;

import clv.cos.odc.customized_dietary.common.dto.ResponseDto;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@UtilityClass
public class ResponseUtil {
    public static ResponseEntity<ResponseDto> get(Object dto, HttpStatus status) {
        return new ResponseEntity<>(
                ResponseDto
                        .builder()
                        .content(dto)
                        .hasErrors(false)
                        .errors(null)
                        .timeStamp(DateTimeUtil.now())
                        .statusCode(status.value())
                        .build(),
                status
        );
    }

//    public static ResponseEntity<ResponseDto> error(Object dto, HttpStatus status) {
//        return new ResponseEntity<>(
//                ResponseDto
//                        .builder()
//                        .content(dto)
//                        .hasErrors(false)
//                        .errors(null)
//                        .timeStamp(DateTimeUtil.now())
//                        .statusCode(status.value())
//                        .build(),
//                status
//        );
//    }
}
