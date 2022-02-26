package expleo.ma.customerservice.mappers;

import expleo.ma.customerservice.dto.CustomerRequestDTO;
import expleo.ma.customerservice.dto.CustomerResponseDTO;
import expleo.ma.customerservice.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponseDTO customerToCustomerResponseDTO(Customer customer);
    Customer customerRequestDTOToCustomer(CustomerRequestDTO customerRequestDTO);
}
