package com.bunroo.incidentmanagement.Response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BaseResponse {
    private String statusCode;
    private String statusMessage;

}
