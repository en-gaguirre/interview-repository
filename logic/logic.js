function exerciseI() {
    const arr = [1, 2, 3, 4, 5];
    const n = arr.length;
  
    for (let i = 0; i < Math.floor(n / 2); i++) {
      let temp = arr[i];
      arr[i] = arr[n - i - 1];
      arr[n - i - 1] = temp;
    }
  
    console.log(arr.join(" "));
  }
  
  function exerciseII(s) {
    let left = 0, right = s.length - 1;
  
    while (left < right) {
      while (left < right && !/[a-z0-9]/i.test(s[left])) left++;
      while (left < right && !/[a-z0-9]/i.test(s[right])) right--;
      if (s[left].toLowerCase() !== s[right].toLowerCase()) return false;
      left++;
      right--;
    }
  
    return true;
  }
  
  function exerciseIII(arr, target) {
    const seen = new Set();
    const pairs = new Set();
  
    for (let num of arr) {
      const complement = target - num;
      if (seen.has(complement)) {
        const pair = [Math.min(num, complement), Math.max(num, complement)].toString();
        pairs.add(pair);
      }
      seen.add(num);
    }
  
    if (pairs.size === 0) console.log("No pairs found");
    else console.log("Pairs:", [...pairs]);
  }
  
