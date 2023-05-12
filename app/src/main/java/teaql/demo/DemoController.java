package teaql.demo;

import cn.hutool.core.map.MapUtil;
import com.doublechaintech.todo.TodoUserContext;
import com.doublechaintech.todo.merchant.Merchant;
import com.doublechaintech.todo.todoitem.TodoItem;
import io.teaql.data.TQLContext;
import io.teaql.data.UserContext;
import io.teaql.data.meta.EntityMetaFactory;
import io.teaql.data.sql.SQLRepositorySchemaHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import com.doublechaintech.todo.Q;

@Controller
public class DemoController {

  @Autowired private EntityMetaFactory factory;

  @GetMapping("/ensureDB")
  @ResponseBody
  public Object ensureTable(@TQLContext UserContext context) {
    new SQLRepositorySchemaHelper().ensureSchema(context, factory);
    return MapUtil.of("ok", true);
  }
  
  @GetMapping("/search")
  @ResponseBody
  public Object query(@TQLContext TodoUserContext context)  {



    return Q.merchant().selectPlatform().executeForList(context);
  }
  @GetMapping("/search2")
  @ResponseBody
  public Object query2(@TQLContext TodoUserContext context) {
    return Q.todoItem().executeForList(context);
  }

  @GetMapping("/new/{name}/")
  @ResponseBody
  public Object newTodo(@TQLContext TodoUserContext context,@PathVariable("name") String name)
          throws Exception {


    TodoItem todoItem=new TodoItem().updateName(name);
    todoItem.updateStatus("TODO");
    todoItem.updateMerchant(Q.merchant().executeForList(context).first());
    return todoItem.save(context);

  }
  @GetMapping("/get/")
  @ResponseBody
  public Object get(@TQLContext TodoUserContext context) {




    return Q.merchant().execute(context);

  }



}
