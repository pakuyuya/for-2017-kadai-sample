package org.ppa.ajaxsmp.service.mock;

import java.util.Calendar;

import org.ppa.ajaxsmp.entity.Employer;
import org.ppa.ajaxsmp.service.EmployerService;

/**
 * テスト動作用のスタブクラス
 */
public class EmployerServiceMock implements EmployerService {

    /**
     * {@inheritDoc}
     * idが"1"の場合のみ、固定値のモデルを返却します。
     */
    @Override
    public Employer findById(String id) {
        if (!"1".equals(id)) {
            return null;
        }

        Employer mock = new Employer();

        mock.setId(id);
        mock.setFamilyName("苗字");
        mock.setFirstName("名前");

        Calendar cal = Calendar.getInstance();
        cal.set(2010, 3, 1, 0, 0, 0);
        cal.set(Calendar.MILLISECOND, 0);

        mock.setSince(cal.getTime());

        return mock;
    }

}
