function nextPermutation(a) {
    // Find the largest nonincreasing suffix starting at a[i]
    var i = a.length - 1
    while (i > 0 && a[i - 1] >= a[i]) i--;
    if (i > 0) {
        // Swap a[i - 1] with the rightmost a[k] > a[i - 1]
        // Note that a[i] > a[i - 1]
        var k = a.length - 1
        while (a[k] <= a[i - 1]) k--;
        swap(a, i - 1, k)
    } // Otherwise, the suffix is the entire array
    // Reverse the suffix
    var j = a.length - 1
    while (i < j) {
        swap(a, i, j);
        i++;
        j--;
    }
}

function swap(arr, i, j) {
    var tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
}

function sort(arr) {
    if (arr.length >= 2) {
        while (true) {
            var isSorted = true;
            for (var j = 1; j < arr.length && isSorted; j++) {
                if (arr[j] < arr[j - 1]) {
                    isSorted = false;
                }
            }

            if (!isSorted) {
                nextPermutation(arr);
            } else {
                for (var i = 0; i < array.length; i++) {
                    print(array[i]);
                }
                break;
            }
        }
    }
}
