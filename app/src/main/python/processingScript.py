import numpy as np
import pandas as pd
import seaborn as sns
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression
from sklearn import tree
from sklearn.metrics import accuracy_score
sns.set()

soildata=pd.read_csv('C:/Users/gaikw/AndroidStudioProjects/SmartAgro/app/src/main/python/data.csv')
soildata.head()


soildata.rename(columns = {'moisture':'Humidity'}, inplace = True)
soildata.rename(columns = {'temp':'Température'}, inplace = True)
soildata.rename(columns = {'pump':'PUMP'}, inplace = True)


x_test,x_train,y_test,y_train=train_test_split(soildata[['Humidity','Température']],soildata.PUMP,train_size=0.7)
x_test.head()

y_train.describe()
y_test.describe()



decision = tree.DecisionTreeClassifier(random_state = 0)


decision.score(x_test, y_test)

decision.score(x_train, y_train)

soildata.head()

y_pred = decision.predict(x_test)
y_pred

print(accuracy_score(y_test,y_pred)*100)