package clv.cos.odc.customized_dietary.common.config.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;

import java.sql.Connection;
import java.util.Properties;

@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})})
@Slf4j
public class SQLInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // Intercept the method call
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        String sql = statementHandler.getBoundSql().getSql(); // Get the SQL statement
        log.info("Executed SQL: {}", sql); // Log the SQL statement
        log.error("Executed SQL: {}", sql); // Log the SQL statement
        return invocation.proceed(); // Proceed with the method invocation
    }


    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        // Set any properties if needed
    }
}