package teaql.demo;

import cn.hutool.core.map.MapBuilder;
import cn.hutool.core.map.MapUtil;


import org.springframework.stereotype.Controller;


import java.util.HashMap;
import java.util.Map;

@Controller
public class DemoController {
//
//  @Autowired private EntityMetaFactory factory;
//
//  @GetMapping("/ensureDB")
//  @ResponseBody
//  public Object ensureTable(@TQLContext UserContext context) {
//    new SQLRepositorySchemaHelper().ensureSchema(context, factory);
//    return MapUtil.of("ok", true);
//  }
//
//  @GetMapping("/search")
//  @ResponseBody
//  public Object query(@TQLContext TodoUserContext context)  {
//
//
//
//    return Q.merchant().selectPlatform().executeForList(context);
//  }
//  @GetMapping("/search2")
//  @ResponseBody
//  public Object query2(@TQLContext TodoUserContext context) {
//    return Q.todoItem().executeForList(context);
//  }
//
//  @GetMapping("/new/{name}/")
//  @ResponseBody
//  public Object newTodo(@TQLContext TodoUserContext context,@PathVariable("name") String name)
//          throws Exception {
//
//
//    TodoItem todoItem=new TodoItem().updateName(name);
//
//
//
//    todoItem.updateStatus("TODO");
//    todoItem.updateMerchant(Q.merchant().executeForList(context).first());
//    return todoItem.save(context);
//
//  }
//  @GetMapping("/newM/{name}/")
//  @ResponseBody
//  public Object newM(@TQLContext TodoUserContext context,@PathVariable("name") String name)
//          throws Exception {
//
//
//    Merchant merchant=new Merchant().updateName("双链科技");
//
//    return merchant.save(context);
//
//  }
//  @GetMapping("/get/")
//  @ResponseBody
//  public Object get(@TQLContext TodoUserContext context) {
//
//    return WebResponse.of(Q.merchant()
//            .findWithJsonExpr("{\"platform.name\":\"平台\"}").executeForList(context));
//
//
//  }
//
//  @GetMapping("/get1/")
//  @ResponseBody
//  public Object get1(@TQLContext TodoUserContext context) {
//    SmartList<Merchant> v = Q.merchant().findWithJsonExpr("{}").executeForList(context);
//    return WebResponse.of(v);
//  }
//
//  @GetMapping("/todolist/")
//  @ResponseBody
//  public Object todolist(@TQLContext TodoUserContext context) {
//
//    return Q.todoItem().executeForList(context);
//  }
//
//
//  @GetMapping("/q/")
//  @ResponseBody
//  public Object q(@TQLContext TodoUserContext context) {
//
//
//
//
//    Object o1=Q.merchant()
//            .selectTodoItemList()
//            .findWithJsonExpr("{\"todoItemList.name\":\"T5\"}").executeForList(context);
//
//    Object o2=Q.todoItem().executeForList(context);
//
//    Object o3=Q.merchant().filterById(1657255672659062784L)
//            .selectTodoItemList()
//            .countTodoItems()
//            //.countTodoItems("countTodoItems001")
//            .executeForList(context);
//
//
//    Map map=new MapBuilder<>(new HashMap<>())
//            .put("o1",o1)
//            .put("o2",o2)
//            .put("o3",o3)
//            .build();
//
//
//    return map;
//  }
//
//
//
//
//  @GetMapping("/find/")
//  @ResponseBody
//  public Object find(@TQLContext TodoUserContext context, @RequestBody String load) {
//    return Q.merchant().findWithJsonExpr(load).executeForList(context);
//  }



}
