package kg.sennamed.sennamed_api.mappers;

import kg.sennamed.sennamed_api.models.dto.AccountDto;
import kg.sennamed.sennamed_api.models.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper {

    AccountMapper INSTANCE= Mappers.getMapper(AccountMapper.class);

    Account toAccount (AccountDto accountDto);
    AccountDto toAccountDto (Account account);
}
