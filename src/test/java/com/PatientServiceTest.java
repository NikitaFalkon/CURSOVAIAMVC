package com;

import com.model.Patient;
import com.repository.PatientRepository;
import com.service.PatientServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PatientServiceTest {
    @Autowired
    PatientServiceImpl patientService;
    @MockBean
    PatientRepository patientRepository;
    @Test
    public void testNewUser() {
        Patient user = new Patient();
        user.setName("name");
        boolean Created = patientService.Create(user);
        System.out.println(Created);
        Assert.assertTrue(Created);
        Assert.assertNotNull(user.getName());
        Mockito.verify(patientRepository, Mockito.times(1)).save(user);
    }
    @Test
    public void testFindUser()
    {
        Patient patient = new Patient();
        patient.setName("u");
        Mockito.doReturn(new Patient())
                .when(patientRepository)
                .findByName("u");
        boolean Exist = patientService.FindPatient(patient);
        Assert.assertTrue(Exist);
    }
    @Test
    public void testRedactUser()
    {
        Patient patient = new Patient();
        patient.setName("name");
        //user.setUsername("user");
        patient.setId((long) 1);
        Mockito.doReturn(new Patient())
                .when(patientRepository)
                .findById((long)1).orElseThrow();
        boolean Redact = patientService.redactPatient(patient.getId(), "notname");
        Assert.assertTrue(Redact);
        Assert.assertEquals(patient.getName(), "name");
    }
}
