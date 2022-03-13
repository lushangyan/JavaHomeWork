package learn.tcc.exchange.api.service;

import learn.tcc.exchange.api.domain.dto.AccountDTO;
import org.dromara.hmily.annotation.Hmily;

/**
 * 美元账户服务
 */
public interface DollarAccountService {


    boolean decrease(AccountDTO accountDTO);

    @Hmily
    boolean increase(AccountDTO accountDTO);

}
