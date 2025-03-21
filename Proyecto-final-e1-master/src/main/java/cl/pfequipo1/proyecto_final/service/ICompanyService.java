package cl.pfequipo1.proyecto_final.service;

import java.util.List;

public interface ICompanyService {

    List<CompanyDTO> findAll();
    CompanyDTO create(CompanyRequestDTO companyRequestDTO);
    CompanyDTO update(Integer id, CompanyRequestDTO companyRequestDTO);
    void delete(Integer id);
    CompanyDTO findById(Integer id);
    List<CompanyAdminViewDTO> getAllCompaniesForAdmin();
    CompanyAdminViewDTO getCompanyByIdForAdmin(Integer id);

}
