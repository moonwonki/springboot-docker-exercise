package springbootdockerexercise.springbootdockerexercise.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello!";
    }

    @GetMapping("/run-script")
    public String runScript() {
        try {
            // 실행할 스크립트 경로
            String scriptPath = "webhook1.sh";

            // 스크립트 실행
            Process process = Runtime.getRuntime().exec(scriptPath);

            // 스크립트 실행이 완료될 때까지 대기
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                return "Script executed successfully.";
            } else {
                return "Script execution failed.";
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "An error occurred while executing the script.";
        }
    }
}
