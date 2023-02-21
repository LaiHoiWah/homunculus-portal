package com.meowu.homunculus.core.snowflake.manager.client;

import com.meowu.commons.security.response.Response;
import com.meowu.support.client.core.snowflake.entity.request.SnowflakeDto;
import com.meowu.support.client.core.snowflake.entity.response.SnowflakeVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "support-service", path = "/api/1.0/snowflake")
public interface SnowflakeClient{

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Response<SnowflakeVo> create(@RequestBody SnowflakeDto snowflakeDto);
}
