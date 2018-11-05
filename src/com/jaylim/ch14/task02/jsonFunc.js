var obj = {
    field1: 10,
    field2: "String"
};

var str = JSON.stringify(obj);
var newStr = JSON.parse(str);

print(str);
print(newStr);

var json = JSON;