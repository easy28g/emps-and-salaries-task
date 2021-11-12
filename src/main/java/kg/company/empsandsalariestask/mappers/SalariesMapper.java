package kg.company.empsandsalariestask.mappers;

import kg.company.empsandsalariestask.models.Salaries;
import kg.company.empsandsalariestask.models.dto.SalariesDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SalariesMapper {

    SalariesMapper INSTANCE = Mappers.getMapper(SalariesMapper.class);

    Salaries toSalaries(SalariesDto salariesDto);
    SalariesDto toSalariesDto(Salaries salaries);

    List<Salaries> toSalariesList(List<SalariesDto> salariesDtoList);
    List<SalariesDto> toSalariesListDto(List<Salaries> salariesList);
}
