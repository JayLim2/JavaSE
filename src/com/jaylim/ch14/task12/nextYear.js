var age
if (typeof $ENV.AGE != 'undefined') {
    age = Number($ENV.AGE);
} else if ($ARG.length != 0) {
    age = Number($ARG[0]);
} else {
    age = Number(readLine('Input your age: '));
}
print('In next year you will be ' + (age + 1) + ' years old.');

/*
jjs -scripting nextYear.js [-- arg1]
*/