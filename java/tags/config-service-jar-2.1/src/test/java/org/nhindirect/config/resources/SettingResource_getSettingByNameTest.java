package org.nhindirect.config.resources;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.nhindirect.config.BaseTestPlan;
import org.nhindirect.config.ConfigServiceRunner;
import org.nhindirect.config.TestUtils;
import org.nhindirect.config.model.Setting;
import org.nhindirect.config.store.dao.SettingDao;

import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

public class SettingResource_getSettingByNameTest 
{
	   protected SettingDao settingDao;
	    
		static WebResource resource;
		
		abstract class TestPlan extends BaseTestPlan 
		{
			@Override
			protected void setupMocks()
			{
				try
				{
					settingDao = (SettingDao)ConfigServiceRunner.getSpringApplicationContext().getBean("settingDao");
					
					resource = 	getResource(ConfigServiceRunner.getConfigServiceURL());		
				}
				catch (Throwable t)
				{
					throw new RuntimeException(t);
				}
			}
			
			@Override
			protected void tearDownMocks()
			{

			}

			protected abstract Collection<Setting> getSettingsToAdd();
			
			protected abstract String getSettingToRetrieve();
			
			@Override
			protected void performInner() throws Exception
			{				
				
				final Collection<Setting> settingsToAdd = getSettingsToAdd();
				
				if (settingsToAdd != null)
				{
					for (Setting addSetting : settingsToAdd)
					{
						try
						{
							resource.path("/api/setting/" + TestUtils.uriEscape(addSetting.getName()) + "/" + TestUtils.uriEscape(addSetting.getValue())).put();
						}
						catch (UniformInterfaceException e)
						{
							throw e;
						}
					}
				}
				
				try
				{
					final Setting setting = resource.path("/api/setting/" + TestUtils.uriEscape(getSettingToRetrieve())).get(Setting.class);

					doAssertions(setting);
				}
				catch (UniformInterfaceException e)
				{
					if (e.getResponse().getStatus() == 404)
						doAssertions(null);
					else
						throw e;
				}
				
			}
				
			protected void doAssertions(Setting setting) throws Exception
			{
				
			}
		}	
		
		@Test
		public void testGetSettingByName_assertSettingRetrieved() throws Exception
		{
			new TestPlan()
			{
				protected Collection<Setting> settings;
				
				@Override
				protected Collection<Setting> getSettingsToAdd()
				{

					settings = new ArrayList<Setting>();
					
					Setting setting = new Setting();					
					setting.setName("setting1");
					setting.setValue("value1");
					settings.add(setting);
					
					setting = new Setting();					
					setting.setName("setting2");
					setting.setValue("value2");
					settings.add(setting);
					
					return settings;

				}

				protected String getSettingToRetrieve()
				{
					return "setting1";
				}
				
				@Override
				protected void doAssertions(Setting setting) throws Exception
				{
					assertNotNull(setting);
					
					final Setting addedSetting = this.settings.iterator().next();
				
					assertEquals(addedSetting.getName(), setting.getName());
					assertEquals(addedSetting.getValue(), setting.getValue());
					
				}
			}.perform();
		}	
		
		@Test
		public void testGetSettingByName_settingNotInStore_assertNoSettingRetrieved() throws Exception
		{
			new TestPlan()
			{
				protected Collection<Setting> settings;
				
				@Override
				protected Collection<Setting> getSettingsToAdd()
				{

					settings = new ArrayList<Setting>();
					
					Setting setting = new Setting();					
					setting.setName("setting1");
					setting.setValue("value1");
					settings.add(setting);
					
					setting = new Setting();					
					setting.setName("setting2");
					setting.setValue("value2");
					settings.add(setting);
					
					return settings;

				}

				protected String getSettingToRetrieve()
				{
					return "settin51";
				}
				
				@Override
				protected void doAssertions(Setting setting) throws Exception
				{
					assertNull(setting);
					
					
				}
			}.perform();
		}		
		
		@Test
		public void testGetSettingByName_errorInLookup_assertServiceError() throws Exception
		{
			new TestPlan()
			{
				
				protected SettingResource settingService;
				
				@Override
				protected void setupMocks()
				{
					try
					{
						super.setupMocks();
						
						settingService = (SettingResource)ConfigServiceRunner.getSpringApplicationContext().getBean("settingResource");

						SettingDao mockDAO = mock(SettingDao.class);
						doThrow(new RuntimeException()).when(mockDAO).getByNames(Arrays.asList("settin51"));
						
						settingService.setSettingDao(mockDAO);
					}
					catch (Throwable t)
					{
						throw new RuntimeException(t);
					}
				}
				
				@Override
				protected void tearDownMocks()
				{
					super.tearDownMocks();
					
					settingService.setSettingDao(settingDao);
				}				
				
				@Override
				protected Collection<Setting> getSettingsToAdd()
				{

					return null;

				}

				protected String getSettingToRetrieve()
				{
					return "settin51";
				}
				
				
				@Override
				protected void assertException(Exception exception) throws Exception 
				{
					assertTrue(exception instanceof UniformInterfaceException);
					UniformInterfaceException ex = (UniformInterfaceException)exception;
					assertEquals(500, ex.getResponse().getStatus());
				}
			}.perform();
		}			
}
