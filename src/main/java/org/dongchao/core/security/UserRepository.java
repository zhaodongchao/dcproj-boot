package org.dongchao.core.security;

import org.dongchao.core.model.DcUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zhaodongchao on 2017/5/5.
 */
public interface UserRepository extends JpaRepository<DcUser, Integer> {
   DcUser findDcUserByUsername(String username) ;
}
