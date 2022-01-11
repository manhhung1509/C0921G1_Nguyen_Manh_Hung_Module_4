package convert.service;

import org.springframework.stereotype.Service;

@Service
public class ConvertServiceImpl implements  ConvertService{
    @Override
    public int convert(int usd) {
        return usd * 22000;
    }
}
