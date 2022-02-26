package expleo.ma.customerservice.service;

import expleo.ma.customerservice.dto.CustomerRequestDTO;
import expleo.ma.customerservice.dto.CustomerResponseDTO;
import expleo.ma.customerservice.entities.Customer;
import expleo.ma.customerservice.mappers.CustomerMapper;
import expleo.ma.customerservice.repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {
        Customer customer=customerMapper.customerRequestDTOToCustomer(customerRequestDTO);
        Customer savedCustomer=customerRepository.save(customer);
        return customerMapper.customerToCustomerResponseDTO(savedCustomer);
    }

    @Override
    public CustomerResponseDTO getCustomer(String idCustomer) {
        Customer customer=customerRepository.findById(idCustomer).get();
        return customerMapper.customerToCustomerResponseDTO(customer);
    }

    @Override
    public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO) {
        Customer customer=customerMapper.customerRequestDTOToCustomer(customerRequestDTO);
        Customer editedCustomer=customerRepository.save(customer);
        return customerMapper.customerToCustomerResponseDTO(editedCustomer);
    }

    @Override
    public void delete(String idCustomer) {
        Customer customer=customerRepository.findById(idCustomer).get();
        customerRepository.delete(customer);
    }

    @Override
    public List<CustomerResponseDTO> listCustomers() {
        List<CustomerResponseDTO> customerResponseDTOList=customerRepository.findAll()
                .stream()
                .map(customer -> customerMapper.customerToCustomerResponseDTO(customer))
                .collect(Collectors.toList());
        return customerResponseDTOList;
    }
}
