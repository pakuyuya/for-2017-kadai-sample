package org.ppa.ajaxsmp.service;

import org.ppa.ajaxsmp.entity.Employer;

/**
 * 従業員クラス
 */
public interface EmployerService {
    /**
     * IDに紐づく従業員情報を取得します。
     *
     * @param id 従業員ID
     * @return 従業員。idに紐づく従業員が存在しない場合は null。
     */
    Employer findById(String id);
}
