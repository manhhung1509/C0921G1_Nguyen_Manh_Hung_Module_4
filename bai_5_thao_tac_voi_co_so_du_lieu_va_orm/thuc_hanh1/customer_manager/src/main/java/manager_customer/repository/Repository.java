package manager_customer.repository;

import java.util.List;

public interface Repository<T> {
    List<T> findAll();

    T finById(Long id);

    void save(T model);

    void remove(Long id);
}
