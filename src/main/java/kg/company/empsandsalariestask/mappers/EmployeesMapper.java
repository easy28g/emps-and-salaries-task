package kg.company.empsandsalariestask.mappers;

import kg.company.empsandsalariestask.models.Employees;
import kg.company.empsandsalariestask.models.dto.EmployeesDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EmployeesMapper {

    EmployeesMapper INSTANCE = Mappers.getMapper(EmployeesMapper.class);

    Employees toEmployees(EmployeesDto employeesDto);
    EmployeesDto toEmployeesDto(Employees employees);

    List<Employees> toEmployeesList(List<EmployeesDto> employeesDtoList);
    List<EmployeesDto> toEmployeesDtoList(List<Employees> employeesList);
}
