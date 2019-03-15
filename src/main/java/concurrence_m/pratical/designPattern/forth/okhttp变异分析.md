## okHttp责任链模式与普通的责任链模式的对比  
Interceptor就是Handler,  
intercept()就是handleReuqest方法  

## Chain中包含了 
1. Request请求对象
2. 所有的Interceptor，这样可以在Chain.procceed()中让当前Interceptor的后继
处理请求。
```
public interface Interceptor {
  Response intercept(Chain chain) throws IOException;

  interface Chain {
    Request request();

    Response proceed(Request request) throws IOException;

    Connection connection();
  }
}
```  

之所以这样设计，个人认为是为了在procceed()函数中指定后继，不需要一次性将所有
Interceptor的后继指定完。  
## Chain.procceed()功能
1.  指定后继Intercepter  
2.  递归调用
```
 public Response proceed
  class RealInterceptorChain{
  Response procceed(Request request){
  //持有所有拦截器和当前Intercerpter后继的Chain
    RealInterceptorChain next = new RealInterceptorChain(
        interceptors, streamAllocation, httpCodec, connection, index + 1, request);
       //获取当前Interceptor
      Interceptor interceptor = interceptors.get(index);
      //递归调用
      Response response = interceptor.intercept(next);
    }
    }
   }
```

3. 在interceptor.intercept()中调用chain.proceed()，在
chain.proceed()中调用interceptor.chain(),这样会将
当前Interceptor和后继Interceptor串联起来。
然后在最后一个拦截器CallServerInterceptor中不会调用chain.proceed(),递归调用
就此结束。