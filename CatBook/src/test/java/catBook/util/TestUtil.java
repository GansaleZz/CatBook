package catBook.util;

import genesis.bean.GenesisBean;

import java.util.Random;

public class TestUtil {

    public static GenesisBean getBeanWithRandomID(Class<? extends GenesisBean> clazz) throws Exception {
        return getBeanWithID(clazz, getRandomLong());
    }

    public static GenesisBean getBeanWithID(Class<? extends GenesisBean> clazz, Long ID) throws Exception {
        GenesisBean result = clazz.newInstance();
        result.setID(ID);

        return result;
    }

    public static Long getRandomLong() {
        return Long.valueOf(getRandomInteger());
    }

    public static Integer getRandomInteger() {
        Random random = new Random();

        return random.nextInt(Integer.MAX_VALUE);
    }
}
