package est.core.repository.common.test;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

import est.core.repository.utils.DbUtils;

@RunWith(GuiceTestRunner.class)
public abstract class DatabaseTestBase {

    @Before
    public void beginTransaction() {
        DbUtils.getTransaction().begin();
    }

    @After
    public void closeEntityManager() {
        DbUtils.closeTransaction();
        DbUtils.closeEntityManager();
    }
}
