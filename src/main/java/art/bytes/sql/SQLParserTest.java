package art.bytes.sql;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLObject;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.SQLSelectStatement;
import com.alibaba.druid.util.JdbcConstants;

import java.util.List;

/**
 * druid 解析 SQL语句
 */
public class SQLParserTest {

    public static void main(String[] args) {
        List<SQLStatement> statementList = SQLUtils.parseStatements("SELECT id FROM order WHERE create_time > '2018-01-01' and field = ? and field2 = ?", JdbcConstants.MYSQL);
        List<SQLObject> sqlObjects = ((SQLSelectStatement) statementList.get(0)).getSelect().getQueryBlock().getWhere().getChildren();
        System.out.println(statementList);

        // 加 where 条件
        System.out.println(SQLUtils.addCondition("SELECT id FROM order WHERE create_time > '2018-01-01' and field = ?", "id = 0", null));
    }

}
