package teaql.demo;

import cn.hutool.core.map.MapUtil;

import com.doublechaintech.cmes.CmesUserContext;
import com.doublechaintech.cmes.E;
import com.doublechaintech.cmes.customorderitem.CustomOrderItem;
import com.doublechaintech.cmes.merchant.Merchant;
import com.doublechaintech.cmes.merchanttype.MerchantType;
import com.doublechaintech.cmes.platform.Platform;
import io.teaql.data.TQLContext;
import io.teaql.data.UserContext;
import io.teaql.data.meta.EntityMetaFactory;
import io.teaql.data.sql.SQLRepositorySchemaHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class CmesController {



  @Autowired
  private EntityMetaFactory factory;

  @GetMapping("/ensure")
  @ResponseBody
  public Object ensureTable(@TQLContext UserContext context) {
    new SQLRepositorySchemaHelper().ensureSchema(context, factory);
    return MapUtil.of("ok", true);
  }



    @GetMapping("/cmes")
    @ResponseBody
    public Object cmes(@TQLContext UserContext context) {



        return "wuhoo";
    }


  @GetMapping("/registerMerchant")
  @ResponseBody
  public Object registerMerchant(@TQLContext UserContext context) {

    Merchant m=new Merchant()
            .updateContactName("YEAH")
            .updateMerchantType(MerchantType.refer(1L))
            .updatePlatform(Platform.refer(1L)).updateName("双链");


    CustomOrderItem item=null;
    if(E.customOrderItem(item).getCustomOrder().getCustomer().getContactName().isNull()){
      //your logic
    }

    E.customOrderItem(item).getCustomOrder().getCustomer().getContactName().whenIsEmpty(()->{
      //do something
    });

    if(isItemNull(item)){
      //fine;
    }



    context.checkAndFix(m);
    return m.save(context);
  }

  private boolean isItemNull(CustomOrderItem item) {

    if(item==null){
      return true;
    }
    if(item.getCustomOrder()==null){
      return true;
    }
    if(item.getCustomOrder().getCustomer()==null){
      return true;
    }
    if(item.getCustomOrder().getCustomer().getName()==null){
      return true;
    }
    return false;
  }



  private boolean isItemNullCrash(CustomOrderItem item) {
    //crash, crash, crash
    if(item.getCustomOrder().getCustomer().getName()==null){
      return true;
    }
    return false;
  }






}
/*

    if(E.customOrderItem(item).getCustomOrder().getCustomer().getContactName().isNull()){
      //your logic
    }





*
*
*
*
* */