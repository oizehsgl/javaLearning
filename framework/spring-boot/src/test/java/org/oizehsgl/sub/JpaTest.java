package org.oizehsgl.sub;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.oizehsgl.sub.jpa.TableService;
import org.oizehsgl.sub.jpa.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

/**
 * jpaTest
 *
 * @author oizehsgl
 * @since 3/19/23
 */
@SpringBootTest
@AutoConfigureMockMvc
public class JpaTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private TableService tableService;

    @Test
    public void testJpa() {
        System.out.println(tableService.findAll());
    }

    @Test
    public void testEvent() throws Exception {
        testPost();
        testPost();
        testPost();
        testGet();
        TimeUnit.SECONDS.sleep(2);
    }

    @Test
    public void testPost() throws Exception {
        UserInfo userInfo = UserInfo.builder().email("eee").name("nnn").build();
        mockMvc.perform(MockMvcRequestBuilders.post("/userInfo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSONObject.toJSONString(userInfo))
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                //.andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().setCharacterEncoding(StandardCharsets.UTF_8.name());
    }

    @Test
    public void testGet() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/userInfo/2")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().setCharacterEncoding(StandardCharsets.UTF_8.name());
    }
}
