package com.fc;

import com.unfbx.chatgpt.OpenAiStreamClient;
import com.unfbx.chatgpt.function.KeyRandomStrategy;
import com.unfbx.chatgpt.interceptor.OpenAILogger;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class,scanBasePackages = "com.fc.v2")
public class V2Application {

	@Value("${chatgpt.apiKey}")
	private List<String> apiKey;
	@Value("${chatgpt.apiHost}")
	private String apiHost;

    public static void main(String[] args) {

        SpringApplication.run(V2Application.class, args);
        System.out.println("*******************************************\n" +
        		"* 码云地址                                  *\n" +
        		"* https://gitee.com/bdj/SpringBoot_v2     *\n" +
        		"*                                         *\n" +
        		"*******************************************\n" +
        		"           _.._        ,-------------------.\n" +
        		"        ,'      `.    ( 启动成功！开启学习之旅！      )\n" +
        		"       /  __) __` \\    `-,-----------------'\n" +
        		"      (  (`-`(-')  ) _.-'\n" +
        		"      /)  \\  = /  (\n" +
        		"     /'    |--' .  \\\n" +
        		"    (  ,---|  `-.)__`\n" +
        		"     )(  `-.,--'   _`-.\n" +
        		"    '/,'          (  Uu\",\n" +
        		"     (_       ,    `/,-' )\n" +
        		"     `.__,  : `-'/  /`--'\n" +
        		"       |     `--'  |\n" +
        		"       `   `-._   /\n" +
        		"        \\        (\n" +
        		"        /\\ .      \\. \n" +
        		"       / |` \\     ,-\\\n" +
        		"      /  \\| .)   /   \\\n" +
        		"     ( ,'|\\    ,'     :\n" +
        		"     | \\,`.`--\"/      }\n" +
        		"     `,'    \\  |,'    /\n" +
        		"    / \"-._   `-/      |\n" +
        		"    \"-.   \"-.,'|     ;\n" +
        		"   /        _/[\"---'\"\"]\n" +
        		"  :        /  |\"-     '\n" +
        		"  '           |      /\n" +
        		"              `      |");


    }

	@Bean
	public OpenAiStreamClient openAiStreamClient() {
		//本地开发需要配置代理地址
//        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 7890));
		HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new OpenAILogger());
		//!!!!!!测试或者发布到服务器千万不要配置Level == BODY!!!!
		//!!!!!!测试或者发布到服务器千万不要配置Level == BODY!!!!
		httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
		OkHttpClient okHttpClient = new OkHttpClient
				.Builder()
//                .proxy(proxy)
				.addInterceptor(httpLoggingInterceptor)
				.connectTimeout(30, TimeUnit.SECONDS)
				.writeTimeout(600, TimeUnit.SECONDS)
				.readTimeout(600, TimeUnit.SECONDS)
				.build();
		return OpenAiStreamClient
				.builder()
				.apiHost(apiHost)
				.apiKey(apiKey)
				//自定义key使用策略 默认随机策略
				.keyStrategy(new KeyRandomStrategy())
				.okHttpClient(okHttpClient)
				.build();
	}

}
