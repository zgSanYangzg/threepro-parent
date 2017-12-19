package cn.three.module.ribbon.command;

/**
 * 没有测试成功.不明所以....注解方式测试通过
 * Created by Administrator on 2017/11/17 0017.
 */
/*public class UserCommand extends HystrixCommand<User> {
    private RestTemplate restTemplate;
    private Long id;

    public UserCommand(RestTemplate restTemplate, Long id) {
        //在注解的实现方式中有替代,更方便
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("CommandGroupKey"))
                        .andCommandKey(HystrixCommandKey.Factory.asKey("CommandKey"))
                        .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("ThreadPoolKey")) //通常情况下,尽量通过HystrixThreadPoolKey 的方式来指定线程池的划分.
                        .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(5000))
                );
        this.restTemplate = restTemplate;
        this.id = id;
    }

    @Override
    protected User run() throws Exception {
        return restTemplate.getForObject("http://hello-service/user/{1}",User.class,id);
    }

    public static void main(String[] args){


        User u = new UserCommand(new RestTemplate(),1L).execute();

        System.out.print(u.getAge());
    }
}*/
