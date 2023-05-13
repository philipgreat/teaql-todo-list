package teaql.demo;

import com.doublechaintech.todo.TodoUserContext;
import io.teaql.data.DataConfigProperties;
import io.teaql.data.TQLContextResolver;
import io.teaql.data.UserContext;
import io.teaql.data.meta.EntityMetaFactory;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.springframework.beans.factory.annotation.Autowired;


public class TestContextResolver implements ParameterResolver {
    //TQLContextResolver


    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {


        //parameterContext.getParameter().getParameterizedType() instanceof UserContext
        return true;
    }
    @Autowired
    private TestDataConfigProperties testDataConfigProperties;
    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        System.out.println(testDataConfigProperties);
        return new TodoUserContext();
    }

    protected DataConfigProperties getDataConfig(){

        DataConfigProperties dataConfigProperties=new DataConfigProperties();

        return dataConfigProperties;


    }


}
