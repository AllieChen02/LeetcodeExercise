var numRescueBoats = function(people, limit) {
    people.sort((a,b) => a - b);  // if we do not pass arrow function (a,b) => a - b, it would sort by the first number instead of its value
    var left = 0, right = people.length() - 1;
    var res = 0;
    while(left <= right){
        res += 1;
        if(people[left] + people[right] <= limit){
            left++;
        }
        right--;
    }
    return res;
};