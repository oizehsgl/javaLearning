package org.oizehsgl.sub;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.oizehsgl.sub.controller.DemoData;
import org.oizehsgl.sub.controller.DemoElement;
import org.oizehsgl.sub.controller.RStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * controllerTest
 *
 * @author oizehsgl
 * @since 3/14/23
 */
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {
    @Autowired
    private MockMvc mockMvc;
//    @Autowired
//    private Validator validator;

    private DemoData demoData;

    private List<DemoData> demoDataList;

    @BeforeEach
    public void setUp() {
        List<DemoElement> demoElementList = new ArrayList<>();
        DemoElement demoElement1 = DemoElement.builder().phone("17805426481").negative(-1).build();
        demoElementList.add(demoElement1);
        DemoElement demoElement2 = DemoElement.builder().phone("17805426482").negative(-2).build();
        demoElementList.add(demoElement2);
        demoData = DemoData.builder().length("dddd").range(4).pattern("0xdd").size(demoElementList).build();
        demoDataList = Collections.singletonList(demoData);
    }

//    @Test
//    public void testValidated() {
//        Set<ConstraintViolation<DemoData>> violations = validator.validate(demoData);
//        if (!violations.isEmpty()) {
//            for (ConstraintViolation<DemoData> violation : violations) {
//                System.out.println(violation.getPropertyPath() + " " + violation.getMessage());
//            }
//        }
//
//    }

    @Test
    public void testPassParameter() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/demo/param/bb/0xbb/2")
                        .header("host", "localhost:8080")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("user", "user")
                        .param("pswd", "pswd")
                        .param("length", "ccc")
                        .param("pattern", "0xcc")
                        .param("range", "3")
                        .content(JSONObject.toJSONString(demoData))
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(RStatus.OK.getCode()))
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().setCharacterEncoding(StandardCharsets.UTF_8.name());
    }

    @Test
    public void testPassParameters() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/demo/param/2,3,4")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("lengths", "a")
                        .param("lengths", "b")
                        .param("lengths", "c")
                        .content(JSONObject.toJSONString(demoDataList))
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(RStatus.OK.getCode()))
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().setCharacterEncoding(StandardCharsets.UTF_8.name());
    }

    @Test
    public void testGet() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/demo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSONObject.toJSONString(demoDataList))
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(RStatus.OK.getCode()))
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().setCharacterEncoding(StandardCharsets.UTF_8.name());
    }

    @Test
    public void testPost() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/demo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSONObject.toJSONString(demoDataList))
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(RStatus.OK.getCode()))
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().setCharacterEncoding(StandardCharsets.UTF_8.name());
    }

    @Test
    public void testPut() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/demo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSONObject.toJSONString(demoDataList))
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(RStatus.OK.getCode()))
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().setCharacterEncoding(StandardCharsets.UTF_8.name());
    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/demo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSONObject.toJSONString(demoDataList))
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(RStatus.OK.getCode()))
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().setCharacterEncoding(StandardCharsets.UTF_8.name());
    }
}
