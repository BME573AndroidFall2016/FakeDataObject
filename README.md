# FakeDataObject
.java file for a fake data object. Provides a data chunk when getData() is called. Timer currently not working. getData() should give you one buffer at a time and then auto-update, so the next call to getData() gives you the next X data points. getData returns an array of DataPoints, which is a graphview object. 
