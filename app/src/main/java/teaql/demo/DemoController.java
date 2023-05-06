package teaql.demo;

import cn.hutool.core.map.MapUtil;
import com.testbank.bank.BankUserContext;
import com.testbank.bank.Q;
import io.teaql.data.TQLContext;
import io.teaql.data.UserContext;
import io.teaql.data.meta.EntityMetaFactory;
import io.teaql.data.sql.SQLRepositorySchemaHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
  public Object query(@TQLContext BankUserContext context) throws Exception {
    return Q.merchantStatus().selectPlatform().executeForList(context);
  }
}
